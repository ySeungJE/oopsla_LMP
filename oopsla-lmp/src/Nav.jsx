import React from 'react';
import {Link} from 'react-router-dom';
import Oopsla from "./assets/Image/Logo.png"

export default function Nav() {
    
    return (
        <div className='page'>
            <header>
            <img className="oopsla-logo" src={Oopsla} alt="oops!a logo" title="none"/>
            </header>
            <div id="top-navigation">
                <ul>
                    <li>About<span class="bar">/</span></li>
                    <li>Notice<span class="bar">/</span></li>
                    <li>Work<span class="bar">/</span></li>
                    <li>Schedule<span class="bar">/</span></li>
                    <li>Login</li>
                </ul>
            </div>
        </div>
    );
}