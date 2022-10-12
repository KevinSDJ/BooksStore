import {axiosInstance} from './../api'


type img={
    nameFile?:string|null,
    type?:string|null,
    data?:string|null
}

export type dataFormValues={
    title?:string|null,
    sinopsis?:string|null,
    price?:number|null,
    cover_front?:img|null
}

export class AdminService {
    public static saveBook(data: dataFormValues, cb: Function): void {
        axiosInstance.post("/books/book",data)
        
        cb()
    }
}