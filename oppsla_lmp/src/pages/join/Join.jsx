import React, {useState, useEffect} from "react"



function Join (props) {
    const [inputId, setInputId] = useState(''); //생성
    const [inputPw, setInputPw] = useState('');

    //변화가 있을 때마다 value의 값을 변경해서 useState
    const updateInputId = (e) => {
        setInputId(e.target.value);
    }

    const updateInputPw = (e) => {
        setInputId(e.target.value);
    }

    //login 버튼 클릭 이벤트
    const onClickLogin = () => {
        console.log('Login!!');
    }


    //axios...?

    return (
        <div>
            <h2>Create your account</h2>
            <p>Create an account to view and manage your projects.</p>
            <div>
                <input type='text' id='' value={inputId} onChange={updateInputId}/>
            </div>
            <div>
                <input type='text' id='' value={inputUsername} onChange={updateInputUsername}/>
            </div>
            <div>
                <input type='text' id='' value={inputPw} onChange={updateInputPw}/>
            </div>
            <div>
                <input type='text' id='' value={inputConfirmPw} onChange={updateInputConfirmPw}/>
            </div>
            <div>
                <button type='button' onClick={onClickJoin}>Create your account</button>
            </div>
        </div>
        
    )
}

export default Join