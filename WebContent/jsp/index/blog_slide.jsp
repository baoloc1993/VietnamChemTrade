 <%@page import="org.jsoup.Jsoup"%>

<%@page import="chemtrade.entity.Blog"%>
<%@page import="chemtrade.controller.blog.BlogController"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Random"%>
<%@page import="java.net.InetAddress"%>
<div id="textslide" style="color:white"></div>
                <%
                    

                    BlogController blogDAO = new BlogController();
                    ArrayList<Blog> blist = blogDAO.getRecentPost();
                %>
                <script>

                    $(document).ready(function () {
                        $('#top_Carousel').carousel('pause');
                    });


                    var quotes = [
                    <%                        for (Blog b : blist) {
                            String d = Jsoup.parse(b.getDescription()).text().trim().replaceAll("[-+.^:,â€˜]", "");;
                            String link = b.getLink();
                            if (d.length() > 900) {
                                d = d.substring(0, 900);
                            }
                    %>
                        "<div style='text-align:justify;'><b><a href='<%=link%>' target='_blank' style='color:white'><%=b.getTitle()%></a></b><br><br><%=d%>...</div>",
                    <%
                        }
                    %>

                    ];

                    var i = 0;

                    setInterval(function () {
                        $("#textslide").html(quotes[i]);
                        if (i == quotes.length)
                            i = 0;
                        else
                            i++;
                    }, 1 * 3000);


                </script>