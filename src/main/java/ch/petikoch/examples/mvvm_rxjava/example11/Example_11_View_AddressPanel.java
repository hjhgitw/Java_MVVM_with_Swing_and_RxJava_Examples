/**
 * Copyright 2015 Peti Koch
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.petikoch.examples.mvvm_rxjava.example11;

import ch.petikoch.examples.mvvm_rxjava.rxjava_mvvm.IView;
import ch.petikoch.examples.mvvm_rxjava.widgets.StrictThreadingJLabel;
import ch.petikoch.examples.mvvm_rxjava.widgets.StrictThreadingJPanel;
import ch.petikoch.examples.mvvm_rxjava.widgets.StrictThreadingJTextArea;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static ch.petikoch.examples.mvvm_rxjava.rxjava_mvvm.RxSwingView2ViewModelBinder.bindSwingView;
import static ch.petikoch.examples.mvvm_rxjava.rxjava_mvvm.RxViewModel2SwingViewBinder.*;

public class Example_11_View_AddressPanel extends StrictThreadingJPanel implements IView<Example_11_ViewModel_Address> {

    private final StrictThreadingJTextArea addressTextArea;
    private final StrictThreadingJLabel dirtyFlagLabel;

    @Override
    public void bind(final Example_11_ViewModel_Address viewModel) {
        bindSwingView(addressTextArea).toViewModel(viewModel.v2vm_address);

        bindViewModelString(viewModel.vm2v_address).toSwingViewText(addressTextArea);
        bindViewModelBoolean(viewModel.vm2v_edit).toSwingViewEnabledPropertyOf(addressTextArea);

        bindViewModel(viewModel.vm2v_dirty).toAction(isDirty -> {
            if (isDirty) {
                dirtyFlagLabel.setText("*");
            } else {
                dirtyFlagLabel.setText("");
            }
        });
    }

    public Example_11_View_AddressPanel() {
        super();

        setBorder(new TitledBorder(null, "Address", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        setLayout(new BorderLayout(0, 0));

        addressTextArea = new StrictThreadingJTextArea();

        JScrollPane scrollPane = new JScrollPane(addressTextArea);
        add(scrollPane, BorderLayout.CENTER);

        dirtyFlagLabel = new StrictThreadingJLabel("");
        add(dirtyFlagLabel, BorderLayout.EAST);
    }
}
