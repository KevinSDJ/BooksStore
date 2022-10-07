import { authService,login,register } from "../auth.service";


class AuthServiceImpl implements authService {

    constructor(){
        
    }
    async(data: unknown, cb: unknown): Promise<void> {
        throw new Error("Method not implemented.");
    }
    async signIn(data: login, cb: Function): Promise<void>{
        let d= fetch("http://hdsadsa").then(r=>r.json())
        await d
        cb(d)
        
    };
    async signUp(data: register, cb: Function): Promise<void>{
        let d= fetch("http://hdsadsa").then(r=>r.json())
        await d
        cb(d)
    };

}

export const AuthService= new AuthServiceImpl()


