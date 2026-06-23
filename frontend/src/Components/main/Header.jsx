import '../../Styles/Main/Defaults.scss';

const Header = () => {
    return(
        <header>
            <h1>The Gamer's Dream</h1>
            <input type="text" placeholder="Qual peça você busca pra turbinar sua máquina...?" />

            <div id="userAccess_box">
                <a>Login</a>
                <a>Cadastro</a>
            </div>
        </header>
    );
};

export default Header;