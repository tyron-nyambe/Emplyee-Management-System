import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import EmployeeComponent from './components/EmployeeComponent'

function App() {
  

  return (
    <>
    <BrowserRouter>
      <HeaderComponent />
      <Routes>
        {/* // http://localhost:3000 */}
        <Route path='/' element = {<ListEmployeeComponent />}></Route>  
        {/* // http://localhost:3000/employees */}
        <Route path='/employees' element = {<ListEmployeeComponent />}></Route>
        {/* //https://loacalhost:3000/add-employee */}
        <Route path='/add-employee' element = {<EmployeeComponent />}></Route>
        {/* //https://loacalhost:3000/edit-employee/1 */}
        <Route path='/edit-employee/:id' element = {<EmployeeComponent />}></Route>
        {/* //https://loacalhost:3000/remove-employee/1 */}
        <Route path='/remove-employee/:id' element = {<EmployeeComponent />}></Route>
        </Routes> 
      
      <FooterComponent />
    </BrowserRouter>
    </>
  )
}

export default App
