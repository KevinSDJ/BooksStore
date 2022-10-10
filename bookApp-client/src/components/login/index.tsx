import { authService } from '../../services/implements/auth.serviceImpl'
import {AiFillEyeInvisible,AiFillEye} from 'react-icons/ai'
import { useState } from 'react';
import {Link} from 'react-router-dom'




const Login = (): JSX.Element => {
  const [viewpass,setViewPass]= useState<Boolean|null>(false)

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    

  };
  const handleViewPass=(event:React.MouseEvent<HTMLDivElement>)=>{
    setViewPass(!viewpass)
  }

  return (
      <form 
      onSubmit={handleSubmit}
      className="lg:w-110 flex flex-col justify-center self-center px-3 py-6 rounded-3xl bg-white">
        <div className="px-6 py-1 bg-white">
          <div className="mb-4 pt-4">
            <h3 className="font-semibold text-2xl text-gray-800">Sign In </h3>
            <p className="text-gray-400 text-sm">Don'thave an account? <Link to={'signUp'}
              className=" text-purple-500 hover:text-purple-700">Sign Up</Link></p>
          </div>
          <div className="space-y-4 w-full">
            <div className="space-y-1 w-full">
              <label className="text-gray-400 font-semibold my-5" >Email</label>
              <input 
              className=" w-full text-sm  px-4 py-3 bg-gray-200 focus:bg-gray-100 border  border-gray-200 rounded-lg focus:outline-none focus:border-purple-400" 
              type="text" name="email" placeholder="Email" required />
            </div>
            <div className="relative space-y-1" x-data="{ show: true }">
              <label className="text-gray-400 font-semibold my-5" >Password</label>
              <input 
              className="text-sm text-gray-500 px-4 py-3 rounded-lg w-full bg-gray-200 focus:bg-gray-100 border border-gray-200 focus:outline-none focus:border-purple-400"
              type={viewpass?'text':'password'}
              required
              />
              <div 
              onClick={handleViewPass}
              className='absolute text-purple-700 text-xl bottom-3 right-4 z-20'>
                {!viewpass&&<AiFillEyeInvisible/>||<AiFillEye/>}
              </div>
            </div>
          </div>
        </div>
        <div className="flex px-6 items-center justify-between">
          <div className="text-sm ml-auto py-2">
            <a href="#" className="text-purple-700 hover:text-purple-600">
              Forgot your password?
            </a>
          </div>
        </div>
        <div className='px-6'>
          <button type="submit" className="w-full flex justify-center bg-purple-800  hover:bg-purple-600 text-gray-100 p-3  rounded-lg tracking-wide font-semibold  cursor-pointer transition ease-in duration-500">
            Sign in
          </button>
        </div>
        <div className="flex items-center justify-center space-x-2 my-2">
          <span className="h-px w-16 bg-gray-400"></span>
          <span className="text-gray-400 font-normal">or</span>
          <span className="h-px w-16 bg-gray-400"></span>
        </div>
        <div className="flex px-6 justify-center gap-5">
          <button 
          type="submit" 
          
          className="disabled:opacity-30 w-full flex items-center justify-center mb-6 md:mb-0 border border-gray-300 hover:border-gray-900 hover:bg-gray-900 text-sm text-gray-500 bg-gray-200 p-3  rounded-lg tracking-wide font-medium  cursor-pointer transition ease-in duration-500">
            <svg className="w-4 mr-2" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path fill="#EA4335" d="M5.266 9.765A7.077 7.077 0 0 1 12 4.909c1.69 0 3.218.6 4.418 1.582L19.91 3C17.782 1.145 15.055 0 12 0 7.27 0 3.198 2.698 1.24 6.65l4.026 3.115Z" /><path fill="#34A853" d="M16.04 18.013c-1.09.703-2.474 1.078-4.04 1.078a7.077 7.077 0 0 1-6.723-4.823l-4.04 3.067A11.965 11.965 0 0 0 12 24c2.933 0 5.735-1.043 7.834-3l-3.793-2.987Z" /><path fill="#4A90E2" d="M19.834 21c2.195-2.048 3.62-5.096 3.62-9 0-.71-.109-1.473-.272-2.182H12v4.637h6.436c-.317 1.559-1.17 2.766-2.395 3.558L19.834 21Z" /><path fill="#FBBC05" d="M5.277 14.268A7.12 7.12 0 0 1 4.909 12c0-.782.125-1.533.357-2.235L1.24 6.65A11.934 11.934 0 0 0 0 12c0 1.92.445 3.73 1.237 5.335l4.04-3.067Z" /></svg>
            <span>Google</span>
          </button>
        </div>
      </form>
     )
}


export default Login