package com.johnpoulakos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.johnpoulakos.domain.Message;
import com.johnpoulakos.domain.MessageGroup;
import com.johnpoulakos.services.MessageService;
import com.johnpoulakos.utils.MessageGroupBuilder;

@RestController
public class TextController {
	
    private MessageService messageService;

    @Autowired
    public void setProductService(MessageService messageService) {
        this.messageService = messageService;
    }
	
	@RequestMapping(value = "/createText", method = RequestMethod.POST)
	@ResponseBody ResponseEntity<?> createText(@RequestBody Message message){
		
		this.messageService.saveMessage(message);	
		
		return new ResponseEntity<String>(message.getMessageText(), HttpStatus.OK);
		
	}
	
	
	@RequestMapping("/getAlltexts")
	@ResponseBody ResponseEntity<?> getAlltexts(){			
		
		return new ResponseEntity<Iterable<Message>>(this.messageService.getAllMessages(), HttpStatus.OK);
		
	}
	
	@RequestMapping("/getAllTextsWithReplies")
	@ResponseBody ResponseEntity<?> getAllTextsWithReplies(){			
		
		Iterable<Message> allMessages = this.messageService.getAllMessages();
		List<MessageGroup> messageGrouplist = this.messageService.getMessgeGroup(allMessages);
		
		return new ResponseEntity<List<MessageGroup>>(MessageGroupBuilder.sortByUser(messageGrouplist), HttpStatus.OK);
		
	}

}
