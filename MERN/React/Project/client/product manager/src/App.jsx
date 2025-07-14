import { Routes, Route } from 'react-router-dom';
import HomeComponent from './components/HomeComponent'
import ProductList from './components/ProductList'
import DisplayProduct from './components/DisplayProduct';
import Update from './components/Update';


function App() {

    return (
        <>
            <Routes>
                <Route path="/"  element={<><HomeComponent /> <ProductList/> </>} />
                <Route path="/product/:id" element={<DisplayProduct />} />
                <Route path="/product/edit/:id" element={<Update/>}   />
            </Routes>

        </>
    )
}

export default App
