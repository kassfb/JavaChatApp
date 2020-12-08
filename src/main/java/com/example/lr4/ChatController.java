package com.example.lr4;

import com.example.lr4.models.Message;
import com.example.lr4.models.MessageRepository;
import com.example.lr4.models.User;
import com.example.lr4.models.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

@Controller
@RequestMapping("chat")
public class ChatController {
    @Autowired
    MessageRepository messagesRepository;
    @Autowired
    UserRepository userRepository;
    //@Autowired
    //User newUser = new User();
    User newUser;
    //@Autowired
    //Message newMessage = new Message();
    Message newMessage;
    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    private Queue<String> messages = new ConcurrentLinkedQueue<>();
    private Map<String, String> usersOnline = new ConcurrentHashMap<>();

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat sdfYear = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm:ss");
    File file = new File("chatHistory.txt");

    public ChatController() throws IOException {
        if (file.exists()) {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                messages.add(line);
                line = reader.readLine();
            }
        }
    }

    /**
     * curl -X POST -i localhost:8080/chat/login -d "name=I_AM_STUPID"
     */
    @RequestMapping(
            path = "login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> login(@RequestParam("name") String name) {
        if (name.length() < 1) {
            return ResponseEntity.badRequest().body("Too short name, sorry :(");
        }
        if (name.length() > 20) {
            return ResponseEntity.badRequest().body("Too long name, sorry :(");
        }
        if (usersOnline.containsKey(name)) {
            return ResponseEntity.badRequest().body("Already logged in:(");
        }
        usersOnline.put(name, name);
        //messages.add("[" + name + "] logged in");
        calendar = Calendar.getInstance();
        String msg = "(" + sdfYear.format(calendar.getTime()) + ") [" + name + "]" + " logged in";
        messages.add(msg);

        //userRepository.save(new User(name, name));
        newUser = new User();
        newMessage = new Message();
        newUser.setUserName(name);
        newUser.setPassword(name);

        newMessage.setMessage(msg);
        newMessage.setUserId(newUser);
        newUser.addMessage(newMessage);//?????
        userRepository.save(newUser);
        messagesRepository.save(newMessage);
        //messagesRepository.save(new Message(msg));
        //newUser.addMessage(newMessage);
        //newMessage.setUserId(newUser);
        //String consoleLoginOut = newUser.toString();
        //System.out.println(newUser.toString());
        //System.out.println(newMessage.toString());

        try (FileWriter writer = new FileWriter("chatHistory.txt", true)) {
            String text = msg;
            writer.append(text);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    /**
     * curl -i localhost:8080/chat/chat
     */
    @RequestMapping(
            path = "chat",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> chat() {
        return new ResponseEntity<>(messages.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n")),
                HttpStatus.OK);
    }

    /**
     * curl -i localhost:8080/chat/online
     */
    @RequestMapping(
            path = "online",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity online() {
        //long i= messagesRepository.count();
        //userRepository.getAllUsersOnline();
        return new ResponseEntity<>(usersOnline.keySet().stream().map(Object::toString)
                .collect(Collectors.joining("\n")),
                HttpStatus.OK);
    }

    /**
     * curl -X POST -i localhost:8080/chat/logout -d "name=I_AM_STUPID"
     */
    @RequestMapping(
            path = "logout",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity logout(@RequestParam("name") String name) {
        //WITHOUT DATABASE
        if (usersOnline.containsKey(name)) {
            usersOnline.remove(name);
            //WITH DATABASE
            //newUser.setUserName(name);
            userRepository.delete(newUser);//!!Удаляет последнего залогиненого пользователя, а не по userName
            //
            calendar = Calendar.getInstance();
            String msg = "(" + sdfYear.format(calendar.getTime()) + ") [" + name + "]" + " logout :(";
            messages.add(msg);
            //WITH DATABASE
            //newMessage.setMessage(msg);
            //messagesRepository.save(newMessage);
            //
            try (FileWriter writer = new FileWriter("chatHistory.txt", true)) {
                String text = msg;
                writer.append(text);
                writer.append('\n');
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.badRequest().body(name + " NOT logged in:(");
        }
    }


    /**
     * curl -X POST -i localhost:8080/chat/say -d "name=I_AM_STUPID&msg=Hello everyone in this chat"
     */
    @RequestMapping(
            path = "say",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity say(@RequestParam("name") String name, @RequestParam("msg") String msg) {
        if (!usersOnline.containsKey(name)) {
            return ResponseEntity.badRequest().body("NOT logged in:(");
        }
        calendar = Calendar.getInstance();
        String msgTime = "(" + sdfYear.format(calendar.getTime()) + ") [" + name + "]: " + msg;
        messages.add(msgTime);
        try (FileWriter writer = new FileWriter("chatHistory.txt", true)) {
            String text = msgTime;
            writer.append(text);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return ResponseEntity.ok().build();//TODO ResponseEntity.ok().build();
    }
}