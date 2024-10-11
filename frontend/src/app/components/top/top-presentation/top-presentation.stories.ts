import type {Meta, StoryObj} from "@storybook/angular";
import {TopPresentationComponent} from "./top-presentation.component";
import {of} from "rxjs";

// story meta config
const meta: Meta<TopPresentationComponent> = {
  title: "Top Presentation",
  component: TopPresentationComponent
};
export default meta;

const mockInput=
  of([{
    item: "admin",
    count: 504
  }, {
    item: "1234",
    count: 302
  }, {
    item: "root",
    count: 201
  }, {
    item: "test",
    count: 200
  }, {
    item: "hello",
    count: 13
  }]);

type TopPasswordsPresentationStory = StoryObj<TopPresentationComponent>;

export const Default: TopPasswordsPresentationStory = {
  args: {
    top: mockInput,
    type: 'password'
  }
};
