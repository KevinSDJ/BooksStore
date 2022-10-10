
import {Outlet} from 'react-router-dom'

const AuthLayout=()=>{
    return(
        <div className='flex justify-center content-center bg-slate-700 w-full h-screen'>
            <Outlet/>
        </div>
    )
}

export default AuthLayout 