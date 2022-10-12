import { Link } from "react-router-dom"
import { useState } from "react"
import {PreviewBook} from './preview_book_form'
import { AdminService,dataFormValues } from "../../services/implements/admin.serviceImpl"

const CreateBook = () => {
    const [formValues,setFormValues] = useState<dataFormValues>({
        title:'',
        sinopsis:'',
        price:0,
        cover_front:null
    })
    

    const handleChange=(event:React.ChangeEvent<HTMLInputElement|HTMLTextAreaElement>)=>{
        setFormValues(prev=>{
            return{...prev,[event.target.name]:event.target.value}
        })
    }
    const handleChangeFile=(event:React.ChangeEvent<HTMLInputElement>)=>{
        const reader= new FileReader()
        let file = event?.currentTarget?.files?.item(0)
        if(file){
            reader.addEventListener("loadend",()=>{
                let data={
                    nameFile:file?.name,
                    type:file?.type,
                    data:reader.result?.toString().split(",")[1]
                }

                console.log(reader.result)

                setFormValues(prev=>{return {...prev,cover_front:data}})
                
                
            })
            reader.readAsDataURL(file)
            
        }else{
            setFormValues(prev=>{return{...prev,cover_front:null}})
        }
    }
    const handleSubmit=(event:React.FormEvent<HTMLFormElement|HTMLFormControlsCollection>)=>{
        event.preventDefault()
        AdminService.saveBook(formValues,(d:any)=>{console.log(d)})
        
    }

    return (
        <div className="flex flex-row justify-between w-full h-screen bg-slate-600">
            <div className="flex basis-2/8 items-center h-full overflow-auto justify-start bg-gray-100" >
                <div className="w-96 px-6 py-6">
                    <h1 className="text-xl font-semibold">Add book to inventory</h1>
                    <small className="text-gray-400">Please enter the data</small>
                    <form className="mt-4" encType={"multipart/form-data"} onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="title" className="mb-2 block text-xs font-semibold">Title</label>
                            <input
                                onChange={handleChange}
                                type="text"
                                
                                maxLength={60}
                                name="title"
                                value={formValues.title||""}
                                placeholder="--------"
                                className="block w-full rounded-md border border-gray-300 focus:border-purple-700 focus:outline-none focus:ring-1 focus:ring-purple-700 py-1 px-1.5 text-gray-500" />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="sinopsis" className="mb-2 block text-xs font-semibold">Sinopsis</label>
                            <textarea
                                onChange={handleChange}
                                
                                value={formValues.sinopsis||""}
                                name="sinopsis"
                                className="block w-full rounded-md border border-gray-300 focus:border-purple-700 focus:outline-none focus:ring-1 focus:ring-purple-700 py-1 px-1.5 text-gray-500" />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="price" className="mb-2 block text-xs font-semibold">Price</label>
                            <div className="flex flex-row justify-between">
                                <input
                                    onChange={handleChange}
                                    type={'number'}
                                    name="price"
                                    value={formValues.price||''}
                                    className="basis-2/4 w-full rounded-md border border-gray-300 focus:border-purple-700 focus:outline-none focus:ring-1 focus:ring-purple-700 py-1 px-1.5 text-gray-500" />
                                <div className="flex items-center ">
                                    $ <span className="w-32 bg-gray-200 py-1 overflow-hidden px-3 ml-2" >{formValues.price||0.0}</span>
                                </div>
                            </div>
                        </div>
                        <div className="mb-3 mt-5">

                            <label className="mb-2 block text-xs font-semibold" htmlFor="cover_front">Cover front</label>
                            <input 
                            className="block transition-all duration-300 file:hover:opacity-80 file:text-gray-200 file:bg-slate-600 file:border-none file:px-4 file:py-2 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 cursor-pointer focus:outline-none"
                            id="cover_front" 
                            onChange={handleChangeFile}
                            name="cover_front"
                            type="file" />

                        </div>
                        <div className="flex flex-end  justify-between mt-12">
                            <button className="rounded-lg hover:opacity-70 bg-purple-700 transition-all duration-300 text-gray-200 py-2 basis-2/6" type="submit">
                                save
                            </button>
                            <Link to='/' className="rounded-lg hover:bg-slate-700 hover:text-gray-300 transition-all duration-300 text-center text-gray-600 bg-gray-300 py-2 basis-2/6">
                                <span>cancel</span>
                            </Link>
                        </div>
                    </form>
                </div>
            </div>
            <div className="basis-4/6 flex">
                <div className="w-11/12 h-5/6 mx-auto self-center shadow-custom1">
                    <PreviewBook {...formValues} />
                </div>
            </div>
        </div>

    )
}

export default CreateBook