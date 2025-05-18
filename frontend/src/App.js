import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import CustomerForm from './components/CustomerForm';
import CustomerList from './components/CustomerList';
import BulkUpload from './components/BulkUpload';


const App = () => {
    return (
        <div className="App">
            <Navbar />
            <Routes>
                <Route path="/" element={<CustomerList />} />
                <Route path="/add-customer" element={<CustomerForm />} />
                <Route path="/bulk-upload" element={<BulkUpload />} />
            </Routes>
        </div>
    );
};

export default App;
