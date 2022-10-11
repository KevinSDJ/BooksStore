

export type dataFormValues={
    title?:string|null,
    sinopsis?:string|null,
    price?:number|null,
    cover_front?:ArrayBuffer|string|null
}


export class AdminService {
    public static saveBook(data: dataFormValues, cb: Function): void {
        console.log(data)
        cb()
    }
}