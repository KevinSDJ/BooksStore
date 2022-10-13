import {SiSpring} from 'react-icons/si'
import {CgMenuGridO} from 'react-icons/cg'
import {IoMdNotifications} from 'react-icons/io'
import {RiAccountPinCircleFill} from 'react-icons/ri'
import {FiSearch} from 'react-icons/fi'

const TopBar=()=>{
    return (
    <header 
    className="w-full  h-fit  shadow-md flex flex-row justify-between py-2 lg:px-12 items-center">
        <div className='flex flex-row  space-x-3 items-center'>
            <div><SiSpring className='text-lime-500 text-3xl'/></div>
            <CgMenuGridO className='text-xl'/>
        </div>
        <div className='relative h-fit'>
               <input type={'text'} className="rounded-md px-3 decoration-0 focus:outline-none text-lg" />
               <FiSearch className="absolute right-2 z-10 top-1"/>
        </div>  
        <div className='flex space-x-4 items-center'>
            {/*el componenete de notificaciones y el de la cuenta*/}
            
            <IoMdNotifications className="text-gray-400 text-2xl"/>
            <div className='flex items-center space-x-2'>
                <RiAccountPinCircleFill className="text-gray-400 text-2xl"/>
                <div className='text-xs '>
                    <p ><b>Lorem inpsum</b></p>
                    <p>Lorem ipsum, dolor sit amet</p>
                </div>
            </div>
        </div>
    </header>
    )
}

export default TopBar