import {Outlet} from 'react-router-dom'
import Sidebar from '../../components/sidebar'
import TopBar from '../../components/topBar'

const Dashboard=()=>{

    return (
        <div className='w-full flex flex-col relative bg-gray-100 h-screen '>
            <TopBar/>
            <div className='grow flex'>
              <Sidebar/>
              <div>
                <Outlet/>
              </div>
            </div>
        </div>
    )
}

export default Dashboard