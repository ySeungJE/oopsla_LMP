import React, {useState} from "react";

const User = {
    email: 'test@example.com',
    pw: 'test2323@@@'
}

export default function Register() {
    const [email, setEmail] = useState('');
    const [userName, setUserName] = useState("");
    const [pw, setPw] = useState("");
    const [pwConfirm, setPwConfirm] = useState("");

    const [emailValid, setEmailValid] = useState(false);
    const [pwValid, setPwValid] = useState(false);
    const [notAllow, setnotAllow] = useState(true);


    const handleEmail = (e) => {
        setEmail(e.target.value);
        const regex =
            /^(([^<>()\[\].,;:\s@"]+(\.[^<>()\[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/i;
        //정규표현식을 활용해서 입력으로 들어온 이메일값이 이 버튼을 활성화하게끔 할 수 있는지(valid)한지 확인
        if(regex.test(email)) {
            setEmailValid(true);
        } else {
            setEmailValid(false);
        }
    }

    const handleUserName = (e) => {
        setUserName(e.target.value);
    }

    const handlePassword = (e) => {
        setPw(e.target.value);
        const regex =
        /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+])(?!.*[^a-zA-z0-9$`~!@$!%*#^?&\\(\\)\-_=+]).{8,20}$/;
        if(regex.test(pw)) {
            setPwValid(true);
        } else {
            setPwValid(false);
        }
    }

    const handlePwConfirm = (e) => {
        setPwConfirm(e.target.value);
    }
    //수정해야 됨
    const onClickConfirmButton = () => {
        if(email === User.email && pw === User.pw) {
            alert('로그인에 성공했습니다.');
        } else {
            alert('등록되지 않은 회원입니다.');
        }
    }

    return (
        <div className='page'>
            <div className='titleWrap'>
                Create your account
            </div>
            <div className='subWrap'>
                Create an account to view and manage your projects.
            </div>
            <div className='contentWrap'>
                <div className='inputTitle'>Email</div>
                <div className='inputWrap'>
                    <input
                    type='text'
                    className='input'
                    placeholder='test@gmail.com'
                    value={email}
                    onChange={handleEmail}/>
                </div>
                <div className='errorMessageWrap'>
                    {
                        !emailValid && email.length>0 && (
                            <div>올바른 이메일을 입력해주세요.</div>
                        )
                    }
                </div>

                <div style={{marginTop: "26px"}} className='inputTitle'>Username</div>
                <div className='inputWrap'>
                    <input
                    type='text'
                    className='input'
                    placeholder="User name"
                    value={userName}
                    onChange={handleUserName}
                    />
                </div>

                <div style={{marginTop: "26px"}} className='inputTitle'>Password</div>
                <div className='inputWrap'>
                    <input
                    type='password'
                    className='input'
                    placeholder="영문, 숫자, 특수문자 포함 8자 이상"
                    value={pw}
                    onChange={handlePassword}
                    />
                </div>
                <div className='errorMessageWrap'>
                    {!pwValid && pw.length>0 && (
                        <div>영문, 숫자, 특수문자 포함 8자 이상 입력해주세요.</div>
                    )}
                </div>

                <div style={{marginTop: "26px"}} className='inputTitle'>Confirm Password</div>
                <div className='inputWrap'>
                    <input
                    type='password'
                    className='input'
                    placeholder="Confirm password"
                    value={pwConfirm}
                    onChange={handlePwConfirm}
                    />
                </div>
                <div className='errorMessageWrap'>
                    {!pwValid && pw.length>0 && (
                        <div>영문, 숫자, 특수문자 포함 8자 이상 입력해주세요.</div>
                    )}
                </div>
                {pw !== pwConfirm && <p>비밀번호가 일치하지 않습니다.</p>}
            </div>
            

            <div>
                <button onClick={onClickConfirmButton} disabled={notAllow} className='bottomButton'>
                    확인
                </button>
            </div>
        </div>  
    );
}