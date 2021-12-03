import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  private url:string = "http://localhost:3000/api";
  constructor(private htppClient:HttpClient) { }

  public getTickets(){
    return this.htppClient.get(this.url+"/tickets");
  }

  public getTicket(id:number){
    return this.htppClient.get(this.url+"/tickets/"+id);
  }

  public updateTicketStatus(id:number,status:any){
    return this.htppClient.put(this.url+"/tickets/"+id,status);
  }
}
