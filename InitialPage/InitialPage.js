import React from 'react';
import '../stylesheet/initialPageStyle.css'
//import '../stylesheet/font-awesome.min.css'



class InitialPage extends React.Component{

    render(){
        return(
               


	<div className="main-bg">
		
		<h1>Diagnostic Medical Center</h1>
		
		<div className="sub-main-w3">
			<div className="image-style">

			</div>
			
			<div className="vertical-tab">

				<div id="section1" className="section-w3ls">
					<input type="radio" name="sections" id="option1" checked />
					<label for="option1" className="icon-left-w3pvt"><span className="fa fa-user-circle" aria-hidden="true"></span>Pateint</label>
					<article>
						<form action="#" method="post">
							<h3 className="legend">Login Here-Patient </h3>
							<div className="input">
								<span className="fa fa-envelope-o" aria-hidden="true"></span>
								<input type="email" placeholder="Email" name="email" required />
							</div>
							<div className="input">
								<span className="fa fa-key" aria-hidden="true"></span>
								<input type="password" placeholder="Password" name="password" required />
							</div>
							<button type="submit" className="btn submit">Login</button>
							<p  className="bottom-text-w3ls">Not an user? <a href="#">Register Here</a></p>
						</form>
					</article>
				</div>

				<div id="section2" className="section-w3ls">
					<input type="radio" name="sections" id="option2"/>
					<label for="option2" className="icon-left-w3pvt"><span className="fa fa-pencil-square" aria-hidden="true"></span>Doctor</label>
					<article>
                        <form action="#" method="post">
							<h3 className="legend">Login Here-Doctor </h3>
							<div className="input">
								<span className="fa fa-envelope-o" aria-hidden="true"></span>
								<input type="email" placeholder="Email" name="email" required />
							</div>
							<div className="input">
								<span className="fa fa-key" aria-hidden="true"></span>
								<input type="password" placeholder="Password" name="password" required />
							</div>
							<button type="submit" className="btn submit">Login</button>
							<p  className="bottom-text-w3ls">Not an user? <a href="#">Register Here</a></p>
						</form>
					</article>
				</div>

				<div id="section3" className="section-w3ls">
					<input type="radio" name="sections" id="option3"/>
					<label for="option3" className="icon-left-w3pvt"><span className="fa fa-lock" aria-hidden="true"></span>Admin</label>
					<article>
                        <form action="#" method="post">
							<h3 className="legend">Login Here-Admin </h3>
							<div className="input">
								<span className="fa fa-envelope-o" aria-hidden="true"></span>
								<input type="email" placeholder="Email" name="email" required />
							</div>
							<div className="input">
								<span className="fa fa-key" aria-hidden="true"></span>
								<input type="password" placeholder="Password" name="password" required />
							</div>
							<button type="submit" className="btn submit">Login</button>
							<p  className="bottom-text-w3ls">Not an user? <a href="#">Register Here</a></p>
						</form>
					</article>
				</div>

                
			</div>
			
			<div className="clear"></div>
		</div>
    </div>   
        );
    }
}


export default InitialPage;