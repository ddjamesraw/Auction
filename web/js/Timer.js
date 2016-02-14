
                                        var milisec = 0
                                        var reloadTime = 3
                                        var seconds = 10
                                     //   var seconds = <c:out value="${requestScope.goodItem.getStartBid()}" />	
                                        document.d.d2.value = '0'
                                        function display() {
                                            if (milisec >= 9) {
                                                milisec = 0
                                                seconds -= 1
                                                reloadTime -= 1;
                                                if (seconds == 0 || reloadTime == 0 )
                                                    window.location.reload(true)
                                            }
                                            else
                                                milisec += 1
                                            document.d.d2.value = seconds
                                            setTimeout("display()", 100)

                                        }
                                        display()

                              