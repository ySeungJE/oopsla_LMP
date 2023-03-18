import React ,{useEffect, useState} from 'react';

function MyPage(props) {
	const [title] = useState('');
  	const [content] = useState('');

	return (
			<div>
  				<div>
    				<h1>{props.title}</h1>
    				<p>{props.content}</p>
  				</div>
			</div>
	);
  }

export default MyPage