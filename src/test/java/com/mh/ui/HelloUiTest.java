/*
Copyright (c) 2015 Mika Hämäläinen

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

package com.mh.ui;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.ui.UI;
import com.vaadin.util.CurrentInstance;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Field;

import static org.mockito.Mockito.verify;

    @RunWith(MockitoJUnitRunner.class)
    public class HelloUiTest {
        private HelloUi ui;

        @Mock
        private Page page;

        @Mock
        private VaadinRequest req;

        @Before
        public void setup() throws Exception {
            initUi();
            mockPage();
        }

        private void initUi() {
            ui = new HelloUi();
            ui.init(req);
            CurrentInstance.setInheritable(UI.class, ui);
        }

        private void mockPage() throws NoSuchFieldException, IllegalAccessException {
            Field pageField = UI.class.getDeclaredField("page");
            pageField.setAccessible(true);
            pageField.set(ui, page);
        }

        @Test
        public void testNotification() {
            ui.getButton().click();

            verify(page).getLocation();
        }
    }
