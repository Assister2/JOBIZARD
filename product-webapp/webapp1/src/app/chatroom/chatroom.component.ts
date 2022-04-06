import { Component, OnInit } from '@angular/core';
import { ChatMessage } from '../model/chat-message';
import { ChatRoom } from '../model/chat-room';
import { ChatroomService } from '../service/chatroom.service';


@Component({
  selector: 'app-chatroom',
  templateUrl: './chatroom.component.html',
  styleUrls: ['./chatroom.component.css']
})
export class ChatroomComponent implements OnInit {

  getChats:ChatMessage[]=[];


  sendChats: ChatMessage = new ChatMessage;


  getChatRoom:ChatRoom[]=[];
  senderID:string = "S123";
  receiverID!:string[];
  receiverNames!:string[];
  receiverName:string = "EFGH";
  messages!:string[];
  text:any;
  sender!:string[];

  constructor(private chatService:ChatroomService) { }

  ngOnInit(): void {
    this.chatService.getMessages().subscribe((data)=>{
      this.getChats = data;
      console.log(data);
      console.log(data.filter((e)=>e.senderId == this.senderID));
      
      this.receiverNames = data.map((e)=>e.recipientName);
      this.receiverID = data.filter((e)=>e.recipientName = this.receiverName).map((e)=>e.recipientId);
      
      
    })

    this.chatService.getChatroom().subscribe((data)=>{
      this.getChatRoom = data;
      console.log(data);
      console.log(data.filter((e)=>e.senderId == this.senderID));
      console.log(data.map((e)=>e.chatId));
      this.receiverID = data.map((e)=>e.recipientId);
      
      data.filter((e)=>e.senderId == this.senderID);
      
    })
  }

  senderId:string = "R123";
  senderName:string = "EFGH";
  recipientId:string = "S123";
  recipientName:string = "ABCD"
  timestamp:any = Date;

  sendMessage(){

    console.log(this.text);
    this.sendChats.senderId = this.senderId;    
    this.sendChats.senderName = this.senderName;
    this.sendChats.recipientId = this.recipientId;
    this.sendChats.recipientName = this.receiverName;
    this.sendChats.timestamp = this.timestamp;
    this.sendChats.message = this.text;
    console.log(this.sendChats);
    
    this.chatService.postMessages(this.sendChats).subscribe((data)=>{
      console.log(data);
      console.log(this.sendChats);
      
    })
    
  }
}
