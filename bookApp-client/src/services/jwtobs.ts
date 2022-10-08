
type tk={
    token:string
}

class JwtAuthProvider{
    key="bkJwt"

    constructor(){
    }

    public existToken():Boolean{
        let tk=localStorage.getItem("bkJwt")?1:0
        return Boolean(tk)
    }
    public getToken():String|null{
        let tk= localStorage.getItem("bkJwt")?localStorage.getItem("bkJwt"):null
        return tk
    } 
    public saveToken(token:tk):void{
        localStorage.setItem(this.key,token.token)
    }
    public deleteToken():void{
        localStorage.removeItem(this.key)
    }

}


export const authProvider= new JwtAuthProvider()