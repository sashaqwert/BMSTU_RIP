import React from 'react';
import {Routes, Route} from "react-router-dom";
import MainPage from "../../pages/main/MainPage";
import Animals from "../../pages/animals/Animals";
import API from "../../pages/api/API";
import AnimalDetail from "../../pages/animals/AnimalDetail";


const Main = () => {
    return (
        <div className="flex wrapper" style={{'textAlign':'center'}}>
            <Routes>
                <Route exact path='/' element={<MainPage/>}/>
                <Route path='/animals' element={<Animals/>}/>
                <Route path='/animal/:id' element={<AnimalDetail/>}/>
                <Route path='/api' element={<API/>}/>
            </Routes>
        </div>
    );
};

export default Main;