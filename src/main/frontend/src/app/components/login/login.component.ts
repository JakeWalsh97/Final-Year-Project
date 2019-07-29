import {Component} from '@angular/core';
import {AppService} from '../../app.service';
import {CustomerService} from '../../customer.service';
import {Router} from '@angular/router';
import {UserService} from '../../shared_service/user.service';
import {User} from '../../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  public users:User[];
  username:String = '';
  password:String = '';
  isValid:boolean;
  isAdmin:boolean;
  accountExists:boolean;

  constructor(private _userService:UserService, private app: AppService, private customer: CustomerService, private router: Router) {
  }

  ngOnInit() {
    this._userService.getUsers().subscribe((users) => {
        console.log(users);
        this.users=users;
    }, (error) => {
      console.log(error);
    })
  }

  tryLogin(username, password) {
          for (var i = 0; i < this.users.length; i++){
            this.isAdmin = false;
            this.isValid = false;
            this.accountExists = false;
            if (username == "admin" && password == "admin"){
              this.isAdmin = true;
              this.router.navigateByUrl('/admin');
            }
            if (this.isAdmin == false){
              if (this.username == this.users[i].username){
                this.accountExists = true;
              }
              if (this.password == this.users[i].password){
                this.isValid = true;
                this.router.navigateByUrl('/home');
              }
            }
          }
  }

}
