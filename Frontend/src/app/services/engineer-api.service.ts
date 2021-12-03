import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EngineerApiService {
  private url:string = "http://localhost:3000/api";
  constructor(private htppClient:HttpClient) { }

  public getEngineers(pincode:any){
    return this.htppClient.get(this.url+"/engineer/" + pincode);
  }

  public assignEngineer(id:any,ticket:any){
    return this.htppClient.post(this.url+"/engineer/"+id,ticket);
  }
}
