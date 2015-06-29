package chemtrade.controller;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;

public class CaptchaController {
	public String getCaptchaHTML(){
		ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LcW3OASAAAAAKEJTHMmp_bo5kny4lZXeDtgcMqC", 
				"6LcW3OASAAAAAKVX2duVsSy2uMMHL105-jPDrHMD", false);
		return c.createRecaptchaHtml(null, null);
	}
}
