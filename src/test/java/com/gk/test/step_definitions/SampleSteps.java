package com.gk.test.step_definitions;

import com.gk.test.models.cucumber.ExampleModel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleSteps {
    private static final Logger LOG = LoggerFactory.getLogger(SampleSteps.class);
    private List<String> unSortedList;
    private List<String> sortedList;
    private List<ExampleModel> unsortedExampleModel;
    private List<ExampleModel> sortedExampleModel;


    @Given("^i add data to Step Definition via List$")
    public void i_add_data_to_Step_Definition_via_List(List<String> listOfValues) {
        unSortedList = listOfValues;
        listOfValues.forEach(e -> LOG.info("Unsorted List " + e));
    }

    @When("^I sort the list using comparator$")
    public void I_sort_the_list_using_comparator() {
        sortedList = unSortedList.stream().sorted().collect(Collectors.toList());
    }

    @Then("^the list is sorted$")
    public void the_list_is_sorted(List<String> expectedSort) {
        assertThat(expectedSort).isEqualTo(sortedList);
        sortedList.forEach(e -> LOG.info("Sorted List " + e));

    }


    @Given("^i add data to Step Definition via Map$")
    public void i_add_data_to_Step_Definition_via_Map(Map<String, String> dataMap) {
        dataMap.keySet().forEach(e -> LOG.info("MAP " + dataMap.get(e)));

    }


    @Given("^i add data to Step Definition via DataTable and DataTable list of Strings$")
    public void i_add_data_to_Step_Definition_via_DataTable_and_DataTable_list_of_Strings(DataTable dataTable) {
        List<String> listString = dataTable.asList(String.class);


        for (String dataTableString : listString)
            LOG.info("DataTableString " + dataTableString);

        List<List<String>> lists = dataTable.asLists(String.class);
        for (List<String> dataTableString : lists)
            for (String dataTableListString : dataTableString)
                LOG.info("DataTableListString " + dataTableListString);


    }


    @Given("^i add multi column data to Step Definition via List of Model$")
    public void i_add_multi_column_data_to_Step_Definition_via_List_of_Model(List<ExampleModel> exampleModelList) {
        unsortedExampleModel = exampleModelList;
        for (ExampleModel model : exampleModelList) {
            LOG.info("Model" + model.getTitle() + model.getLocation() + model.getProcess());

        }
    }


    @When("^I sort the multi column data using comparator$")
    public void I_sort_the_multi_column_data_using_comparator() {
        sortedExampleModel = unsortedExampleModel.stream().sorted((a, b) -> b.getLocation().compareTo(a.getLocation())).collect(Collectors.toList());
    }

    @Then("^the multi column data is sorted by title$")
    public void the_multi_column_data_is_sorted_by_title() {

    }

    @Given("^i add multi column data to Step Definition via Transposed List of Model$")
    public void i_add_multi_column_data_to_Step_Definition_via_Transposed_List_of_Model(@Transpose List<ExampleModel> exampleModelList) {
        for (ExampleModel model : exampleModelList) {
            LOG.info("Transposed Model" + model.getTitle() + model.getLocation() + model.getProcess());

        }
    }


}
