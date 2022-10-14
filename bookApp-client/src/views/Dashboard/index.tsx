import {Outlet} from 'react-router-dom'
import Sidebar from '../../components/sidebar'
import TopBar from '../../components/topBar'

const Dashboard=()=>{

    return (
        <div className='w-full flex flex-col relative bg-gray-100 h-screen '>
            <TopBar/>
            <div className='grow flex flex-row space-x-2 bg-slate-500'>
              <Sidebar/>
              <div className='bg-gray-200 grow max-h-full overflow-auto mt-2 rounded-md'>
                <Outlet/>
              </div>
            </div>
        </div>
    )
}

export default Dashboard