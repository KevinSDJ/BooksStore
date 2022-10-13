import {BrowserRouter as RouterApp,Routes,Route} from 'react-router-dom'
import {lazy,Suspense} from 'react'

const Home = lazy(()=>import('./Home'))
const AuthLayout = lazy(()=>import('./AuthLayout'))
const Login = lazy(()=>import('./../components/login'))
const Register= lazy(()=>import('./../components/register'))
const NotFoundPage=lazy(()=>import('./NotFound'))
const CreateBookPage =lazy(()=>import('./AddBooks'))
const Dashboard= lazy(()=>import("./Dashboard"))

function App() {
  return (
    <Suspense fallback={<div>Loading ...</div>}>
      <RouterApp>
        <Routes>
          <Route path='/' element={<Home/>} />
          <Route path="auth" element={<AuthLayout/>}>
             <Route path='' element={<Login/>}/>
             <Route path='signUp' element={<Register/>}/>
          </Route>

          {/* Administration section */}
          <Route path="admin" element={<Dashboard/>}>
            <Route path="" element={<div><h1>Hadsdsd</h1></div>}/>
            <Route path='add'element={<CreateBookPage/>} />
          </Route>
          <Route path='*' element={<NotFoundPage/>} />
        </Routes>
      </RouterApp>
    </Suspense>
  )
}

export default App
