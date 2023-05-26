import React from 'react';

import { Navigation } from 'react-minimal-side-navigation';
import 'react-minimal-side-navigation/lib/ReactMinimalSideNavigation.css';

export default function Sidebox() {

    return (
        // <Navigation
        //     //you can use your own router's api to get pathname
        // />
        <div>
            <div id="navigation">
                <ul id="vertical-menu">
                    <li>About
                        <ul>
                            <li>Oops!a란?</li>
                            <li>Members</li>
                            <li>졸업 후 진로</li>
                        </ul>
                    </li>
                    <li>Notice</li>
                    <li>Work</li>
                    <li>Schedule</li>
                    <li>Login</li>
                </ul>
            </div>
            <div id="search-box"></div>
        </div>
    );
}