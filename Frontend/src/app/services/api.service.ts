import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class APIService {
  private url:string = "http://localhost:3000/api/admin/users";
  constructor(private htppClient:HttpClient) { }

  public addUser(user:any){
    return this.htppClient.post(this.url,user);
  }
  public getUsers(){
    return this.htppClient.get(this.url);
  }
  public getUser(id:number){
    return this.htppClient.get(this.url+"/"+id);
  }
  public updateUser(id:number,user:any){
    return this.htppClient.put(this.url+"/"+id,user);
  }
  public deleteUser(id:number){
    return this.htppClient.delete(this.url+"/"+id);
  }
}
