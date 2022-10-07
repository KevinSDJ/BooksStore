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

export interface authService{
    async (data:login,cb:Function):Promise<void>,
    async (data:register,cb:Function):Promise<void>
}
