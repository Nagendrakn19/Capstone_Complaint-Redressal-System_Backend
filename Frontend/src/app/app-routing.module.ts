import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EngineerComponent } from './components/engineer/engineer.component';
import { LoginComponent } from './components/login/login.component';
import { AssignEngineerComponent } from './components/manager/assign-engineer/assign-engineer.component';
import { ManagerComponent } from './components/manager/manager.component';

const routes: Routes = [
  {path:'',redirectTo:'/login',pathMatch:'full'},
  {path:'login',component:LoginComponent},
  {path:'admin', loadChildren:()=> import('./components/admin/admin.module').then(m=> m.AdminModule)},
  {path:'customer',loadChildren:()=> import('./components/customer/customer.module').then(m=> m.CustomerModule)},
  {path:'manager',component:ManagerComponent},
  {path:'manager/assign/:tktid/:pincode',component:AssignEngineerComponent},
  {path:'engineer',component:EngineerComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
