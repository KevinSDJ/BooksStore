import {BrowserRouter as RouterApp,Routes,Route} from 'react-router-dom'
import {lazy,Suspense} from 'react'

const Home = lazy(()=>import('./Home'))
const AuthLayout = lazy(()=>import('./AuthLayout'))
const Login = lazy(()=>import('./../components/login'))
const Register= lazy(()=>import('./../components/register'))

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
          <Route path='/newbook' element={<div>sd</div>}/>
        </Routes>
      </RouterApp>
    </Suspense>
  )
}

export default App
