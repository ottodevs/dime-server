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

package fi.hiit.dime.data;

import fi.hiit.dime.authentication.User;
import fi.hiit.dime.search.WeightedKeyword;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import java.util.List;

/** Parent object of all DiMe database objects.
*/
@JsonInclude(value=JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="@type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "new"})
@JsonSubTypes({
            @JsonSubTypes.Type(value=fi.hiit.dime.data.Document.class, name="Document"),
            @JsonSubTypes.Type(value=fi.hiit.dime.data.ScientificDocument.class, name="ScientificDocument"),
            @JsonSubTypes.Type(value=fi.hiit.dime.data.Message.class, name="Message"),
            @JsonSubTypes.Type(value=fi.hiit.dime.data.Person.class, name="Person"),
            @JsonSubTypes.Type(value=fi.hiit.dime.data.FeedbackEvent.class, name="FeedbackEvent"),
            @JsonSubTypes.Type(value=fi.hiit.dime.data.Document.class, name="Document"),
            @JsonSubTypes.Type(value=fi.hiit.dime.data.DesktopEvent.class, name="DesktopEvent"),
            @JsonSubTypes.Type(value=fi.hiit.dime.data.ReadingEvent.class, name="ReadingEvent"),
            @JsonSubTypes.Type(value=fi.hiit.dime.data.MessageEvent.class, name="MessageEvent"),
            @JsonSubTypes.Type(value=fi.hiit.dime.data.SearchEvent.class, name="SearchEvent"),
})
@MappedSuperclass
public class DiMeData extends AbstractPersistable<Long> {
    public String appId;

    public void copyIdFrom(DiMeData e) {
        setId(e.getId());
    }

    public void resetId() {
        setId(null);
    }

    /** User associated with the object - automatically generated by
        DiMe.
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User user;

    /** Method to call when ever a new object has been uploaded, e.g.
        to clean up user provided data, or perform some house keeping
        before storing in the database.
    */
    public void autoFill() {} 

    @Transient
    public Float score;

    @Transient
    public List<WeightedKeyword> weightedKeywords;
}
