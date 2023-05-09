import React, {useState, useEffect} from 'react'
import axios from 'axios';

const User = {
    email: 'test@example.com',
    pw: 'test2323@@@'
}

//Login 컴포넌트에는 email, pw, emailValid, pwValid, notAllow이라는 5개의 상태 값을 사용
export default function Login() {
    const [email, setEmail] = useState('');
    const [pw, setPw] = useState("");

    const [emailValid, setEmailValid] = useState(false);
    const [pwValid, setPwValid] = useState(false);
    const [notAllow, setnotAllow] = useState(true);


    //handleEmail 함수는 입력된 이메일 값이 올바른 형식인지 정규 표현식으로 검증하고, 검증 결과에 따라 emailValid 상태 값을 업데이트
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

    //handlePassword 함수는 입력된 이메일 값이 올바른 형식인지 정규 표현식으로 검증하고, 검증 결과에 따라 pwValid 상태 값을 업데이트한다
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

    //onClickConfirmButton 함수는 입력된 이메일과 비밀번호 값이 User 객체의 이메일과 비밀번호 값과 일치하는지 확인하고, 결과에 따라 로그인 성공 여부를 알린다
    const onClickConfirmButton = () => {
        if(email === User.email && pw === User.pw) {
            alert('로그인에 성공했습니다.');
        } else {
            alert('등록되지 않은 회원입니다.');
        }
    }
    
    //useEffect 훅은 emailValid와 pwValid 값이 변경될 때마다 실행된다. 두 값이 모두 true이면 notAllow 값을 false로 업데잍트하고, 그렇지 않으면 true로 업데이트한다.
    useEffect (() => {
        if(emailValid && pwValid) { //true이면
            setnotAllow(false); //비활성화 상태를 풀어줌
            return;
        }
        setnotAllow(true); //기본적으로는 비활성화
    }, [emailValid, pwValid]);

    return (
        <div className='page'>
            <div className='titleWrap'>
                이메일과 비밀번호를<br/>입력해주세요
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
            </div>
            

            <div>
                <button onClick={onClickConfirmButton} disabled={notAllow} className='bottomButton'>
                    확인
                </button>
            </div>
        </div>  
    );
}