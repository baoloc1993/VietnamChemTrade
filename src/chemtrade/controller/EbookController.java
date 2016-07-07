/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.controller;



import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chemtrade.configuration.ConnectionManager;
import chemtrade.configuration.Constant;

/**
 *
 * @author Fla
 */
@WebServlet("/ebook")
public class EBookController extends HttpServlet implements Constant {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.getRequestDispatcher("jsp/ebook.jsp").forward(req, resp);
	}
	
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
       
        try{
	        String str_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	       
	        int i = getLastDownloadId() + 1;
	        insertEbook(i, request.getParameter("designation"), request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("emailid"), str_date2, request.getRemoteAddr());
	         
	        sendEmail(request.getParameter("emailid"),request.getParameter("first_name"), request.getLocalAddr());
        }catch (SQLException e){
        	response.sendError(411, e.getMessage());
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	response.sendError(412, e.getMessage());
		}
        
          
    }
    public void sendEmail(String email,String name, String localAddress) throws Exception{
		String mailF = "<table  style=\"background-color: #f2f2f2; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none\" width=\"870\">\n" +
"    <tbody><tr>\n" +
"            <td  style=\"background-color: #f2f2f2;\">\n" +
"                <div align=\"center\">\n" +
"                    <table cellpadding=\"0\" width=\"600\" cellspacing=\"0\" border=\"0\">\n" +
"                        <tbody><tr>\n" +
"                                <td align=\"center\"  style=\"background-color: #f2f2f2\">\n" +
"                                    <!-- start header section -->\n" +
"                                    <div class=\"header-container-wrapper\">\n" +
"                                        <table class=\"wrappertable\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"600\">\n" +
"                                            <tbody>\n" +
"                                                <tr>\n" +
"                                                    <td valign=\"top\" colspan=\"12\" width=\"100.0%\" class=\"\" style=\"width:100.0%; text-align: left; padding: 0; font-family: sans-serif; font-size: 15px; line-height: 1.5em; color: #444444; \">\n" +
"                                                        <div class=\"widget-span widget-type-email_view_as_web_page \" style=\"\" data-widget-type=\"email_view_as_web_page\">\n" +
"\n" +
"\n" +
"                                                        </div><!--end widget-span -->\n" +
"                                                    </td>\n" +
"                                                </tr>\n" +
"                                            </tbody></table>\n" +
"                                    </div><!--end header wrapper -->\n" +
"                                    <!-- end header section -->\n" +
"                                </td>\n" +
"                            </tr>\n" +
"                        </tbody></table>\n" +
"                </div>\n" +
"            </td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td  style=\"padding: 10px 20px; background-color: #f2f2f2\">\n" +
"                <div align=\"center\">\n" +
"                    <table cellpadding=\"0\" width=\"600\" cellspacing=\"0\" border=\"0\">\n" +
"                        <tbody><tr>\n" +
"                                <td id=\"main_body\" width=\"600\" bgcolor=\"#ffffff\" style=\"padding: 30px; background-color: #ffffff; border: 1px solid #cccccc; border-bottom: 1px solid #acacac; border-radius: 4px\">\n" +
"                                    <div align=\"center\">\n" +
"                                        <table cellpadding=\"0\" width=\"600\" cellspacing=\"0\" border=\"0\">\n" +
"                                            <!-- start content -->\n" +
"                                            <tbody><tr>\n" +
"                                                    <td style=\"padding: 0; background-color: #ffffff\">\n" +
"                                                        <div align=\"center\">\n" +
"                                                            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"font-family:sans-serif; font-size: 15px; line-height: 1.5em; color: #444444\">\n" +
"                                                                <tbody><tr>\n" +
"                                                                        <td>\n" +
"                                                                            <div align=\"center\">\n" +
"                                                                                <!-- start body section -->\n" +
"                                                                                <div class=\"body-container-wrapper\">\n" +
"                                                                                    <table class=\"wrappertable\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"600\">\n" +
"                                                                                        <tbody>    \n" +
"                                                                                            <tr>\n" +
"                                                                                                <td valign=\"top\" colspan=\"12\" width=\"100.0%\" class=\"\" style=\"width:100.0%; text-align: left; padding: 0; font-family: sans-serif; font-size: 15px; line-height: 1.5em; color: #444444; \">\n" +
"                                                                                                    <div class=\"widget-span widget-type-logo \" style=\"\" data-widget-type=\"logo\">\n" +
"                                                                                                        <div class=\"layout-widget-wrapper\">\n" +
"                                                                                                            <div id=\"hs_cos_wrapper_module_14321731151782375\" class=\"hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_logo\" style=\"color: inherit; font-size: inherit; line-height: inherit; margin: inherit; padding: inherit\" data-hs-cos-general-type=\"widget\" data-hs-cos-type=\"logo\">\n" +
"                                                                                                                <a href=\""+ ROOT +"\" id=\"hs-link-module_14321731151782375\" style=\"border-width:0px;border:0px;\"><img src=\"http://cdn2.hubspot.net/hub/492768/hubfs/logo.png?t=1434423261005&amp;width=300\" class=\"hs-image-widget \" style=\"max-height:111px; max-width:300px; border-width:0px;border:0px;\" width=\"300\" alt=\"Tradeasia International\" title=\"Tradeasia International\" /></a></div>\n" +
"                                                                                                        </div><!--end layout-widget-wrapper -->\n" +
"                                                                                                    </div><!--end widget-span -->\n" +
"                                                                                                </td>\n" +
"                                                                                            </tr>\n" +
"                                                                                            <tr>\n" +
"                                                                                                <td valign=\"top\" colspan=\"12\" width=\"100.0%\" class=\"\" style=\"width:100.0%; text-align: left; padding: 0; font-family: sans-serif; font-size: 15px; line-height: 1.5em; color: #444444; \">\n" +
"                                                                                                    <div class=\"widget-span widget-type-email_body \" style=\"\" data-widget-type=\"email_body\">\n" +
"\n" +
"                                                                                                        <div id=\"hs_cos_wrapper_hs_email_body\" class=\"hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_rich_text\" style=\"color: inherit; font-size: inherit; line-height: inherit; margin: inherit; padding: inherit\" data-hs-cos-general-type=\"widget\" data-hs-cos-type=\"rich_text\"><p style=\"margin-bottom: 1em; \">Chào bạn  " + name + ",</p>\n" +
"                                                                                                            <p style=\"margin-bottom: 1em; text-align: left;\">Cảm ơn bạn đã quan tâm tới chúng tôi. Bạn có thể tải Ebook thông qua link dưới đây.</p>\n" +
"                                                                                                            <p style=\"margin-bottom: 1em; \"><a href=\"http://info.chemtradeasia.com/e1t/c/*W7Q4VXd72DgNrW91mwj96QY4yw0/*W7bMYSc5tJTP-W2pddTG6GBpLw0/5/f18dQhb0S1Xn6SyJVvL_GYHlQBGgVymLhr4Zn5dMN2S6fthCZZpxN53Qr38G2xQpW208SWN7_S0zTW6TKhsx8wx1_0W8GDkYG54Kt24W1lG9XF2SFmqyW92zns74l4vyDW9fXbxt5VSrQvN1-c6w3F2G25W8SHdfM3KZKy6N2RTkdxd-YwTW3DdqDk4VPXspW2BQcLt6fpv48W98MCK_2K6JZwW83gTQR5YXkgSW2Mb3Kg3ggzMnW8KpzMv31qLYPW6b_fCr5bglybW9cmsZN5CjkGTW2BFfBZ6JbNZsN4h-Gz_ym5J8W71PF448J-GqCW7BP_D68Q5NS2W7BJ_6D76CzHfN5ZR3XbBK90bW7NTSp313PgbXW4Wwwbd3t0H2HW1gLSNs5yJtPyVXnsqF65xs-KW1Mprc67sJvQfW1bw0qB3Yk1fpW4bQM2g5hSHqgW6zQzzl7wCp7_W59p95T6PRmXGW8ymyS92GxhjKW7_CR6t29kK4WW5bgpHK5L8RMgW40t4bj24_J46W58QMg29kgW1hW2_3rhF6FwNg3W9k2JZg8ytkcnVH-BTh4rK1CvW97KZDY3rbBp_W6--c6v6_PvWBf3-06t203\"><img src=\"http://cdn2.hubspot.net/hub/492768/hubfs/CoverPage.jpg?t1434423261005&amp;width=186\" alt=\"CoverPage\" width=\"186\" style=\"max-width: 186px; max-height: 807px; width: 186px; float: right;\" align=\"right\" /></a></p>\n" +
"                                                                                                            <p style=\"margin-bottom: 1em; text-align: justify;\"><a href=\"http://info.chemtradeasia.com/e1t/c/*W7Q4VXd72DgNrW91mwj96QY4yw0/*W7bMYSc5tJTP-W2pddTG6GBpLw0/5/f18dQhb0S1Xn6SyJVvL_GYHlQBGgVymLhr4Zn5dMN2S6fthCZZpxN53Qr38G2xQpW208SWN7_S0zTW6TKhsx8wx1_0W8GDkYG54Kt24W1lG9XF2SFmqyW92zns74l4vyDW9fXbxt5VSrQvN1-c6w3F2G25W8SHdfM3KZKy6N2RTkdxd-YwTW3DdqDk4VPXspW2BQcLt6fpv48W98MCK_2K6JZwW83gTQR5YXkgSW2Mb3Kg3ggzMnW8KpzMv31qLYPW6b_fCr5bglybW9cmsZN5CjkGTW2BFfBZ6JbNZsN4h-Gz_ym5J8W71PF448J-GqCW7BP_D68Q5NS2W7BJ_6D76CzHfN5ZR3XbBK90bW7NTSp313PgbXW4Wwwbd3t0H2HW1gLSNs5yJtPyVXnsqF65xs-KW1Mprc67sJvQfW1bw0qB3Yk1fpW4bQM2g5hSHqgW6zQzzl7wCp7_W59p95T6PRmXGW8ymyS92GxhjKW7_CR6t29kK4WW5bgpHK5L8RMgW40t4bj24_J46W58QMg29kgW1hW2_3rhF6FwNg3W9k2JZg8ytkcnVH-BTh4rK1CvW97KZDY3rbBp_W6--c6v6_PvWBf3-06t203\">Tải ebook miễn phí</a></p>\n" +
"                                                                                                            <p style=\"margin-bottom: 1em; \">Để tìm hiểu thêm sản phẩm, xin hãy vui lòng theo dõi chúng tôi. <a href=\"http://blog.chemtradeasia.com\">Blog</a>.<br /><br />Để biết về chúng tôi, hãy truy cập vào trang web:  <a href=\""+ ROOT + ">" + ROOT + "</a>\n" +
"                                                                                                            </p>\n" +
"                                                                                                            <p style=\"margin-bottom: 1em; \">&nbsp;</p>\n" +
"                                                                                                            <p style=\"margin-bottom: 1em; \">Thân,</p>\n" +
"                                                                                                            <p style=\"margin-bottom: 1em; \">Tradeasia International Pte Ltd</p></div>\n" +
"\n" +
"\n" +
"                                                                                                    </div><!--end widget-span -->\n" +
"                                                                                                </td>\n" +
"                                                                                            </tr>\n" +
"                                                                                            <tr>\n" +
"                                                                                                <td valign=\"top\" colspan=\"12\" width=\"100.0%\" class=\"\" style=\"width:100.0%; text-align: left; padding: 0; font-family: sans-serif; font-size: 15px; line-height: 1.5em; color: #444444; \">\n" +
"                                                                                                    <div class=\"widget-span widget-type-social_sharing \" style=\"\" data-widget-type=\"social_sharing\">\n" +
"                                                                                                        <div class=\"layout-widget-wrapper\">\n" +
"                                                                                                            <div id=\"hs_cos_wrapper_module_14321731711833436\" class=\"hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_social_sharing\" style=\"color: inherit; font-size: inherit; line-height: inherit; margin: inherit; padding: inherit\" data-hs-cos-general-type=\"widget\" data-hs-cos-type=\"social_sharing\">\n" +
"                                                                                                                <a href=\"http://info.chemtradeasia.com/e1t/c/*W7Q4VXd72DgNrW91mwj96QY4yw0/*W8bV-xd91kJ-ZW5qz0k13bwS4F0/5/f18dQhb0S1Wd7BfGH_W12NntK2mC_4fW4-vGSJ72-L_RW7nyTll30tCySW7_pGy251KmsWW2s95RF6Qsn1XW3PCTmN5mPtpFW4sT25216G22ZW69Vjps6MSqrNW2Fqy7C835MqgW6V011L6-tfDJW61Q6gZ8sNjTGW7CdDb33VyYGHN3r0_V3JyLV1W390kLd37PR0XVFjKpV79xD6hW5hT1k27bF8rXW3NVqSQ1ZdS1rW8vM9204JTp20W78dt523WNP_cW5VLS1D5vsHl_W4p4qrQ4JHrZPVW934Q2SwHJKW7DFfWh7wSSDMW90D8MS73rvF9W1xJbr85dKn7CW40Gk572Yg8bWW49d77z1VkxxVW1HytTX59c71LW99z3n25k45GkVVQTzk8dv0sYM6psjkVpjbnW356Swn4yCT2kVM11_23tZTvKW22Fn2Y4CYmrjV3wpvb3F5vvrW1DXrqz39qbd-N2NjZby7BFqMW6pN9Mm8TyCcmW6-dktG1b69g0W4xbq0D2HS6njW3jw0Fb2xNBQYW3czB_c7D_CjXW5cS28k6wCqtsW5LRZ9d55fz8hW7_YvgB5Wrx6SW5FNQbF3MmxjhW87h0l04g1MGcW9g-jXh2YPHLFW2VB9791Mb0BzW3q7d4R5Bl-D_W8Dv_w38Sj2yNW8896g36rfxKzW9722Cr5pytfXW6zGs9j89r5_FVfW3dq89xGQl103\" target=\"_blank\" style=\"width:24px;border-width:0px;border:0px;\"><img src=\"https://static.hubspot.com/final/img/common/icons/social/facebook-24x24.png?width=24\" class=\"hs-image-widget hs-image-social-sharing-24\" style=\"max-height:24px;max-width:24px;border-width:0px;border:0px;\" width=\"24\" hspace=\"0\" alt=\"Share on Facebook\" /></a>&nbsp;\n" +
"                                                                                                                <a href=\"http://info.chemtradeasia.com/e1t/c/*W7Q4VXd72DgNrW91mwj96QY4yw0/*W3ykVvH8kZGF4N71-C_ZWFbh10/5/f18dQhb0S1Wb7Bf-yPW12hDt-3yw258W2wJC0r2nkQpdW6J1qxd4QS6qkW6DKQ3p8y8WYRW8_5nkV8TRS6wW6HG7sz7SJ28QW7tBzCR92cpt_W1Myb8B4MMJ6mW4-NkYW5L1kNVW4rKS0s3k0z9tW6KLHpD8MXxXxW372Btm4hvJZtW388hX_3lRxnbW1kzFR-1jVBkKW3QCbwC2bshYJW8mnyvk1-RWSZW4qYtfW139wLsW8R2f5n7q7Vb4W23f4mD77WmlsW3xt3Db6GhlPrV6PPVJ1DS8HPN1fz_r3sbC34N6vkxpXsZ4RvW1bMcjx8Y0fSjVxNnMQ4fwg6YN5JXdkdF9-5GVLSz-M1Mh_DZW58VKhj23NHr7W3bl8Mw8tY-7kN5B6xrG5SZbzN1V2H6bMKF4HW200l121QtHkPW3z3lym3L_qxVW1PLcXy21nCrFW8bq33M6Cx1kXV6hwWf4091pWW4xb62n5Mtw4rW8D8pnT71YTHtW8xDSDZ8CDLh_W8CY1hL18jsN8W3bJsgV2167zKW648fYm6LJsWdW5cr32V4bvr0VW7Bn2bN6XG04bW4pz_y95mm43NW3Kdj3T8BxLdvW6x5GQR8qyj03W75VrkM90LhytW3YPm5T73YMp-W4lxbNj6YDNClW7XCVRF3Gdq45W8DCjzQ18FM0wW8mFtN-4CzLRfW9gqQdM98-3J5W3vX4qR1CPnV-f2zHtKb11\" target=\"_blank\" style=\"width:24px;border-width:0px;border:0px;\"><img src=\"https://static.hubspot.com/final/img/common/icons/social/linkedin-24x24.png?width=24\" class=\"hs-image-widget hs-image-social-sharing-24\" style=\"max-height:24px;max-width:24px;border-width:0px;border:0px;\" width=\"24\" hspace=\"0\" alt=\"Share on LinkedIn\" /></a>&nbsp;\n" +
"                                                                                                                <a href=\"http://info.chemtradeasia.com/e1t/c/*W7Q4VXd72DgNrW91mwj96QY4yw0/*VNrVsG2f-Q9rW5y_-sD4GHvkK0/5/f18dQhb0S1Wb7Bf-yvV1x-Rt4TTsYsN8gJ8S2qlQhBW3Ykf1N1TJhfGW5wyZt-1D8cHnW8dmb415Qk-JJW86-NN16VgRzyW4vk_cW77ZbsVW4SnVhR2bJWkgW52bsSn3KsN5JW8ZmllX8QNwfGW8Vc32z1KKwl-W5L8dWS6FM86LN6K3TnFSr-MPW3YW3bj3DBSYGW47gsyJ2Gj2zsVj2hGt1TtX68W4WQP_03Cqb7DW4S58QQ62Nwv7W15Xh8T2vc1G0W4MK_Vz3Z2CsJW3HjG9q1TbDsgVyMfYK8bt8rFW8mq4Fh4hy5DGW1vr5PH7lj9wVW52_RW94j7-5VW4k4Swr5hbz7WW7QXxSB1MQh7LW4hp88p5zXJZdW4wHmYj6t6rdRW60h8yz2ck-YMW2JcG5_50rC7MVp6rWj1BS5Q2W5xpQfM8CzKTNVMWrlP2MPPVLN7vCLy7RJ0BCN6k1G_F9fWMDVQTNxB5VctVZW1s5xGX1MSyfqN4LlqQc357wtV-lXgn3LlvHgW5stcH79826DRN4ljwK-VF01KVWr93c1_TXspW6pr4yp5JbzM4W6xRkzG8fB7ljW6qNBRd1BQlpzW8dTfk96xKRr4W6mPSWK8dDTZNW59B03w90StnPN6WR639cjsW7W8JmpL_7KT_82W6Tr8Ls392cYjN5RzgjHMH_wJW5SNfZ21CwkB1W1JPhVJ8gSysBW9j_fDr8jPNtFW6-hLWJ9jRBF3W8j3Mz24BCzYpW18FShN974xpSW2jmBxt20RvnhW6_cdTc9k7Vlcf1vzYYz02\" target=\"_blank\" style=\"width:24px;border-width:0px;border:0px;\"><img src=\"https://static.hubspot.com/final/img/common/icons/social/twitter-24x24.png?width=24\" class=\"hs-image-widget hs-image-social-sharing-24\" style=\"max-height:24px;max-width:24px;border-width:0px;border:0px;\" width=\"24\" hspace=\"0\" alt=\"Share on Twitter\" /></a>&nbsp;\n" +
"                                                                                                                <a href=\"http://info.chemtradeasia.com/e1t/c/*W7Q4VXd72DgNrW91mwj96QY4yw0/*V7r70q8hBvznW4JNKWp71C_K-0/5/f18dQhb0S1Wd7BwhLlW12NqYv72gnwFW1gt3-43vySGLW6B-j0y7_8RDsW6Hyq0c8JyQlwW8g1LHm2Vb1LFW1q6gS67kjX8vW5rtM8K7Nr183W9bGBl71L3cjWN8lrcS5FpyGFW2V7bvH2g41c3W7Z0MnB9jC52BW5sB0-_6SMv_-W7sb0Hy4y4g5lVYpMHb1FWyD7W8ZCGzm3n3cr8W2v9bL52MXKzjVm5cdP5D4pTjW1XlXJ23wM1jHVVn_l24jMnbcW4fYzKj24lyBRVjr3P73zdbKvW2Bz1FX3lZZy9W4fzc_r41tcVxW90TCvT3xfczpW34ngvT5fqxdZW4dXzGl2rQz0KW355nRG5Lr5PLVMVvmh3cZD2vVZkSHV3Pnd1fN7l4_xwYh76qW2-SmNh2T84z4W1ng5Qm55WjVWW37krP7320Y7sW25y7pY47d-SxN7FzMsY6XnVYW7bw8_v5jLXBkN2fNl21kbxdWW77S27m59796LN6kgq9QfLTpyW3sVh7q1x5j8jW5nPN_-66WqxjW6YT4wX87TYZgW85YCtk519dnRW7z638b277H6bW8DYn5D6P8qk7W1d1STF54pKggW7M_S385tcm4VW7XbYBj8QW2GqW5lSzwZ1Mwz1KW94FxJg2hQyLRW9jRDKG4Rf-zGW4DB0Nd18DC2mW8ywT0L4HtWkyW6pqgG496gW3jW8SLmrn8CNpJL102\" target=\"_blank\" style=\"width:24px;border-width:0px;border:0px;\"><img src=\"https://static.hubspot.com/final/img/common/icons/social/googleplus-24x24.png?width=24\" class=\"hs-image-widget hs-image-social-sharing-24\" style=\"max-height:24px;max-width:24px;border-width:0px;border:0px;\" width=\"24\" hspace=\"0\" alt=\"Share on Google+\" /></a></div>\n" +
"                                                                                                        </div><!--end layout-widget-wrapper -->\n" +
"                                                                                                    </div><!--end widget-span -->\n" +
"                                                                                                </td>\n" +
"                                                                                            </tr>\n" +
"                                                                                        </tbody></table>\n" +
"                                                                                </div><!--end body wrapper -->\n" +
"                                                                                <!-- end body section -->\n" +
"                                                                            </div>\n" +
"                                                                        </td>\n" +
"                                                                    </tr>\n" +
"                                                                </tbody></table>\n" +
"                                                        </div>\n" +
"                                                    </td>\n" +
"                                                </tr>\n" +
"                                                <!-- end content -->\n" +
"                                            </tbody></table>\n" +
"                                    </div>\n" +
"                                </td>\n" +
"                            </tr>\n" +
"                        </tbody></table>\n" +
"                </div>\n" +
"            </td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td  style=\"background-color: #f2f2f2;padding: 13px 30px\">\n" +
"                <div align=\"center\">\n" +
"                    <table cellpadding=\"0\" width=\"600\" cellspacing=\"0\" border=\"0\">\n" +
"                        <tbody><tr>\n" +
"                                <td align=\"center\"  style=\"background-color: #f2f2f2\">\n" +
"                                    <!-- start footer section -->\n" +
"                                    <div class=\"footer-container-wrapper\">\n" +
"                                        <table class=\"wrappertable\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"600\">\n" +
"                                            <tbody>\n" +
"                                                <tr>\n" +
"                                                    <td valign=\"top\" colspan=\"12\" width=\"100.0%\" class=\"\" style=\"width:100.0%; text-align: left; padding: 0; font-family: sans-serif; font-size: 15px; line-height: 1.5em; color: #444444; \">\n" +
"                                                        <div class=\"widget-span widget-type-email_can_spam \" style=\"\" data-widget-type=\"email_can_spam\">\n" +
"                                                            <p id=\"footer\" style=\"margin-bottom: 1em; font-family: Geneva, Verdana, Arial, Helvetica, sans-serif; text-align: center; font-size: 12px; line-height: 1.34em; color: #999999; display: block\">\n" +
"                                                                Tradeasia International Pte Ltd\n" +
"                                                                &nbsp;&nbsp;133 Cecil Street\n" +
"                                                                &nbsp; #12-03 Keck seng Tower\n" +
"                                                                &nbsp;Singapore,\n" +
"                                                                &nbsp;Singapore\n" +
"                                                                &nbsp;&nbsp;069535\n" +
"                                                                &nbsp;&nbsp;Singapore\n" +
"                                                                <br /><br />\n" +
"                                                                You received this email because you are subscribed to Marketing Informationfrom Tradeasia International Pte Ltd.\n" +
"                                                                <br /><br />\n" +
"                                                                Update your <a class=\"hubspot-mergetag\" data-unsubscribe=\"true\" href=\n" +
"                                                                               \"http://info.chemtradeasia.com/e1t/c/*W7Q4VXd72DgNrW91mwj96QY4yw0/*W7Z9bsr51FRlVV7WzZw7KGfDq0/5/f18dQhb0S2C82fcTYHV11R9v6c_XQ-MdvhQKF9tyLW2LZTxh6gxy82W1YT0T97LrjlwW2MVlSX8FdmkJW7hzs446sg_6sW6vKYw-88F1lKMR8b5ml__R1W2qLM188VTj6cW8WrwK194xqN0W4kJ24V98h7YNW2YvWqk5LLpy6N1JDF2ChfXyzW8yldFP1J1nzsW1-zmdB40T7LcW3Jyl4d22QhC0W3RfxL21cT-MHW3g0qYd78MDWZW3Y0drd7Fdc3yN20770JHY-ycW1nmDXJ59gQykW4096j11B43tQW3MnSw21398krW4n3B8f7lgGc6W77ZXGM52JsWJW3px1Cz7N6TT4W4BhvKN5-WhCsN7_QXxTDSL2sW2F3DKZ6Fg7J1W2Q9bgH93jFCyW3Cl0Xx610VtyW1gXGQP6tST-9W2nHcTM4WsT7RW1pyGHf8Ck99KW7V-GnQ54FgktW7YR8Q41tK3xTW8tsR_W2WtQ7wW15t8cF2jCdgdW5PzWQ-2_2_wSW31Y_826PHM67W3Wsh222Cwg8NV-nNkj6vgg_VW83Wc414pPGXqW5P8R7y3rYk3TN2PcFp6H8rK3W37p8813FNbNbW6J3jSc8LG86KW367WJ_5sGnDcW5k9-jw6bYcLqVvR70Q32H-1XW44mW6W4pHHkxW8WwdQJ33zKP3W4G3CDb9l-NC8W6F_zNR92w-NkW8LGzY58chnt6f7nzP9204\" style=\"text-decoration: underline; whitespace: nowrap; color: #999999;\">email preferences</a> to choose the types of emails you receive.\n" +
"                                                                <br /><br />\n" +
"                                                                &nbsp;<a class=\"hubspot-mergetag\" data-unsubscribe=\"true\" href=\"http://info.chemtradeasia.com/e1t/c/*W7Q4VXd72DgNrW91mwj96QY4yw0/*W4pBWpG92VVPdW92Vj3S7L0mCN0/5/f18dQhb0S3j41QyjWsV11pLH33WMDwV2DYW-5gkwHnW3XB7Mg66F6wkVfdLRp85BkQHW3PC0-V55dhhDW4kPnZl8-VPfxW4NfbnD6Yp1kvW3qv5nb1p_LX6W67JbGL2l5J-QW6YPDdG7TjmPLW1rV4qm86_b6HW6jbyfc6g3gycW8nX7H_5vfpvPW4Tf9hs4PLmDVMnJ4fldGW1MW31l5mR1s_qDYW60p5W62vr2wjW66BxSF2QQRJmW1bc9wg4g8qQDW8w9nnN5bTKgSW2QMVT-3MDmbhVxy9fl8H90gfW6txxtD3GCRVFW7t7gty8S_8brW4Lhs2Q1QkRL6W5wj6nW1VpRsJW4dbx_Y8HfkpLV-FvSV8nvPywW8g6gQK19cydSW7Pn_Hv5yZN-yMG4sf1CFPGjW5jkPF38NVw2WN777f109R3ytW13m6ZX9kp7q5VD8fzf3prQlwW3t0-v78YJVcBW59BJ488slrfWW7Q9Fdn3Wv3pPN37c2MyXLLPHW5f55K12KSW9ZW5HpPnK7zGvB1W14jQkR6_l6ggW43dpbM5pfMYwW2dVX69858kVwW8tlBr52mx3b3W6xT9qh73Bx9ZN99cVv5VlvZKW1xKFDf22svX7W3kJbFp4pdNhtW4Q36h196vKCtW7z0-5h7bYJ_yW2TFmwd954ZM_W4qK1509f8mYhW4G9TWQ44DctnW9k5cG88NGHGQf7RkSjp02\" style=\"text-decoration: underline; whitespace: nowrap; color: #999999;\">Unsubscribe from all future emails</a>&nbsp;\n" +
"                                                            </p>\n" +
"\n" +
"                                                        </div><!--end widget-span -->\n" +
"                                                    </td>\n" +
"                                                </tr>\n" +
"                                            </tbody></table>\n" +
"                                    </div><!--end footer wrapper -->\n" +
"                                    <!-- end footer section -->\n" +
"                                </td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td></td>\n" +
"                            </tr>\n" +
"                        </tbody>\n" +
"                    </table>\n" +
"                </div>\n" +
"            </td>\n" +
"        </tr>\n" +
"    </tbody>\n" +
"</table>";

		EmailController emailController = new EmailController();
		emailController.sendEmailViaGmail(email, mailF.replaceFirst("NAMENAMENAME", name), "Cảm ơn bạn đã tải Ebook");
		
       
		
	   // this.mailSender.send(msg);
	    
	}

	
	
	public int getLastDownloadId() throws SQLException {
		
      
        Connection conn;
        
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("select download_id from tbl_ebook order by download_id DESC LIMIT 1");
            ResultSet rs = ps.executeQuery();
            if (!rs.next()){
            	return 0;
            }else{
            	return rs.getInt(1);
            }
            	
            
        
    }

    public void insertEbook(int id, String designation, String firstName, String lastName, String email, String time, String ip) throws SQLException {
        Connection conn;

        
            conn = ConnectionManager.getConnection();
            String sql = "INSERT INTO `tbl_ebook` (`download_id`, `designation`, `first_name`, `last_name`,`emailid`,`created_on`, `ip_address`) VALUES "
                    + "(" + id + ", '" + designation + "', '" + firstName + "', '"
                    + lastName + "', '" + email + "', '" + time + "', '" + ip + "');";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.execute();
        
    }

}
