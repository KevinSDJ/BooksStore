import {MdSpaceDashboard} from 'react-icons/md'
import {ImBooks} from 'react-icons/im'
import {BsClipboardData} from 'react-icons/bs'
import {MdCategory} from 'react-icons/md'
import {BsWalletFill} from 'react-icons/bs'
import {RiShoppingCartFill} from 'react-icons/ri'
import {IoLogOutSharp} from 'react-icons/io5'
import {Link} from 'react-router-dom'
import { useState } from 'react'

const Sidebar=()=>{
   
    return (
    <nav className="w-fit  py-8 h-full bg-gray-100 shadow-md">
        <ul className={`flex flex-col justify-start space-y-6 w-full`}>
            <li className='text-2xl w-full px-8'>
                <Link to="#" className='flex justify-start flex-row space-x-2 items-center '>
                    <MdSpaceDashboard className='text-purple-800'/> 
                    <span className="text-sm" >inicio</span>
                </Link>
            </li>
            <li className='text-2xl w-full px-8 py-2 bg-gray-200'>
                <Link to="#" className='flex justify-start flex-row space-x-2 items-center'>
                    <ImBooks className='text-purple-800'/> 
                    <span className="text-sm" >inicio</span>
                </Link>
            </li>
            <li className='text-2xl w-full px-8'>
                <Link to="#" className='flex justify-start flex-row space-x-2 items-center'>
                    <BsClipboardData className='text-purple-800'/> 
                    <span className="text-sm" >inicio</span>
                </Link>
            </li>
            <li className='text-2xl w-full px-8'>
                <Link to="#" className='flex justify-start flex-row space-x-2 items-center'>
                    <BsWalletFill className='text-purple-800'/> 
                    <span className="text-sm" >inicio</span>
                </Link>
            </li>
            <li className='text-2xl w-full px-8'>
                <Link to="#" className='flex justify-start flex-row space-x-2 items-center'>
                    <MdCategory className='text-purple-800'/> 
                    <span className="text-sm" >inicio</span>
                </Link>
            </li>
            <hr/>
            <li className='text-2xl w-full px-8'>
                <Link to="#" className='flex justify-start flex-row space-x-2 items-center'>
                    <RiShoppingCartFill className='text-purple-800'/>
                    <span className="text-sm" >inicio</span>
                </Link>
            </li>
            <li className='text-2xl w-full px-8'>
                <Link to="#" className='flex justify-start flex-row space-x-2 items-center'>
                    <IoLogOutSharp className='text-purple-800' />
                    <span className="text-sm" >inicio</span>
                </Link>
            </li>
            
        </ul>
    </nav>
    )
}


export default Sidebar