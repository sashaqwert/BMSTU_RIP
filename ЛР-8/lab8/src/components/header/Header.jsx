import React from 'react';
import {Link} from "react-router-dom";

const Header = () => {
    return (
        <nav>
            <div className="container d-flex justify-content-center mb-1">
                <ul className="nav nav-tabs">
                    <li className="nav-item"><Link className="nav-link" to='/'>Главная</Link></li>
                    <li className="nav-item"><Link className="nav-link" to='/animals'>Животные</Link></li>
                    <li className="nav-item"><Link className="nav-link" to='/api'>API</Link></li>
                </ul>
            </div>
        </nav>
    );
};

export default Header;