export type register={
    username?:String,
    email?:String,
    password?:String
}

export type login={
    email?:String,
    password?:String
}



// servicio de authenticacion 

export interface AuthService {
    signIn(data:login,cb:Function):void,
    signUp(data:register,cb:Function):void
}
