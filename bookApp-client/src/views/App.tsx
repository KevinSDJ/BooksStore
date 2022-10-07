import {BrowserRouter as RouterApp,Routes,Route} from 'react-router-dom'
import {lazy,Suspense} from 'react'

const Home = lazy(()=>import('./Home'))




function App() {
  return (
    <Suspense fallback={<div>Loading ...</div>}>
      <RouterApp>
        <Routes>
          <Route path='/' element={<Home/>} />
        </Routes>
      </RouterApp>
    </Suspense>
  )
}

export default App
