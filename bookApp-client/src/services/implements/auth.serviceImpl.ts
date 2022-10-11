import { AuthService,login,register } from "../auth.service";
import{axiosInstance} from './../api'

class AuthServiceImpl implements AuthService {

    constructor(){
        
    }
    signIn(data: login, cb: Function) {
        axiosInstance.post('/auth/login',data)
        .then(r=>{
            cb(r)
        })
        .catch(error=>{
            cb(error)
        })
    }
    signUp(data: register, cb: Function) {
        axiosInstance.post("/auth/register",data)
        .then(r=>{
            cb(r)
        })
        .catch(error=>{
            cb(error)
        })
    }
    
}

export const authService= new AuthServiceImpl()


