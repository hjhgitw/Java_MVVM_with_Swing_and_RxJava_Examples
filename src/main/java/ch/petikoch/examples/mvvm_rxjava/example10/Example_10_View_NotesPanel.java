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
package ch.petikoch.examples.mvvm_rxjava.example10;

import ch.petikoch.examples.mvvm_rxjava.rxjava_mvvm.IView;
import ch.petikoch.examples.mvvm_rxjava.widgets.StrictThreadingJPanel;
import ch.petikoch.examples.mvvm_rxjava.widgets.StrictThreadingJTextArea;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static ch.petikoch.examples.mvvm_rxjava.rxjava_mvvm.RxSwingView2ViewModelBinder.bindSwingView;
import static ch.petikoch.examples.mvvm_rxjava.rxjava_mvvm.RxViewModel2SwingViewBinder.bindViewModelBoolean;
import static ch.petikoch.examples.mvvm_rxjava.rxjava_mvvm.RxViewModel2SwingViewBinder.bindViewModelString;

public class Example_10_View_NotesPanel extends StrictThreadingJPanel implements IView<Example_10_ViewModel_Notes> {

    private final StrictThreadingJTextArea notesTextArea;

    @Override
    public void bind(final Example_10_ViewModel_Notes viewModel) {
        bindSwingView(notesTextArea).toViewModel(viewModel.v2vm_notes);

        bindViewModelString(viewModel.vm2v_notes).toSwingViewText(notesTextArea);
        bindViewModelBoolean(viewModel.vm2v_edit).toSwingViewEnabledPropertyOf(notesTextArea);
    }

    public Example_10_View_NotesPanel() {
        super();

        setBorder(new TitledBorder(null, "Notes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        setLayout(new BorderLayout(0, 0));

        notesTextArea = new StrictThreadingJTextArea();

        JScrollPane scrollPane = new JScrollPane(notesTextArea);
        add(scrollPane, BorderLayout.CENTER);
    }
}
