/*
  Copyright (c) 2015 University of Helsinki

  Permission is hereby granted, free of charge, to any person
  obtaining a copy of this software and associated documentation files
  (the "Software"), to deal in the Software without restriction,
  including without limitation the rights to use, copy, modify, merge,
  publish, distribute, sublicense, and/or sell copies of the Software,
  and to permit persons to whom the Software is furnished to do so,
  subject to the following conditions:

  The above copyright notice and this permission notice shall be
  included in all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
  BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
  ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  SOFTWARE.
*/

package fi.hiit.dime.authentication;

//------------------------------------------------------------------------------

import fi.hiit.dime.data.User;
import fi.hiit.dime.data.Role;
import javax.validation.constraints.NotNull;

//------------------------------------------------------------------------------

/**
   Data object for the user creation form.
*/
public class UserCreateForm {
    @NotNull
    private String username = "";
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @NotNull
    private String password = "";
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @NotNull
    private String passwordRepeated = "";
    public String getPasswordRepeated() { return passwordRepeated; }
    public void setPasswordRepeated(String passwordRepeated) { 
	this.passwordRepeated = passwordRepeated; }
    
    @NotNull
    private Role role = Role.USER;
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}