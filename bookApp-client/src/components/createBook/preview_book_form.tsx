import ImageIcon from '/image_icon.webp'
import { formV } from './types'


export const PreviewBook=({cover_front,title,sinopsis,price}:formV)=>{

    return (
        <div className="flex flex-row max-w-full  w-full h-full rounded-lg overflow-hidden" >
            <div className="bg-white basis-3/6 flex items-center justify-center ">
               <img className='w-4/6 max-h-full overflow-auto' src={cover_front?.toString()||ImageIcon} />
            </div>
            <div className="max-h-full px-4  w-3/6">
                <div className='text-gray-300 space-y-8 w-full mt-12 shrink'>
                    <div className='w-full'>
                       <p className='text-gray-400 '><b>Title</b></p>
                       <p className='text-xl max-w-sm break-words'>{title||"none"}</p>
                    </div>
                    <div className='w-full'>
                       <p  className='text-gray-400'><b>Sinopsis</b></p>
                       <p className='max-w-sm max-h-36 break-words overflow-y-auto'>{sinopsis||'none'}</p>
                    </div>
                    <div>
                       <p  className='text-gray-400'><b>Price</b></p>
                       <p>{"$ "+price||'$0.0'}</p>
                    </div>
                    <div>
                       <p  className='text-gray-400'><b>Categories</b></p>
                       <p>none</p>
                    </div>
                </div>
            </div>
        </div>
    )
}
