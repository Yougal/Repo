export class AuthService{
  
  loggedIn = false;
  
  isAuthenicated(){
    const promise = new Promise<boolean>(
      (resolve, reject)=>{
        setTimeout(()=>resolve(this.loggedIn),100);
        }
    );
    return promise;
  }
  
  login(){
    this.loggedIn=true;
  }
  logout(){
    this.loggedIn=false;
  }
}