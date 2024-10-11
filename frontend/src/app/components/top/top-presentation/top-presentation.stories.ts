import type { Meta, StoryObj } from "@storybook/angular";
import {TopPresentationComponent} from "./top-presentation.component";
import {TopPasswordsPresentation} from "./top-passwords-presentation.interface";
import {of} from "rxjs";

// story meta config
const meta: Meta<TopPresentationComponent> = {
  title: "TopPasswordsPresentation",
  component: TopPresentationComponent
};
export default meta;

const mockInput: TopPasswordsPresentation = {
  passwords: of([{
    password: "admin",
    count: 504
  }, {
    password: "1234",
    count: 302
  }, {
    password: "root",
    count: 201
  }, {
    password: "test",
    count: 200
  }, {
    password: "hello",
    count: 13
  }])
};

type TopPasswordsPresentationStory = StoryObj<TopPresentationComponent>;

export const Default: TopPasswordsPresentationStory = {
  args: {
    topPasswords: mockInput
  }
};
