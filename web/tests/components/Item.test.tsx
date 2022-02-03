import React from "@testing-library/react";
import { render } from "@testing-library/react";

import Item from "../../src/components/Item";
import sampleImage from "../../assets/images/sample.png";
import Youniverse from "../../src/Youniverse";

describe('Item', () => {
    it('renders Youniverse item', () => {
        const { container_item } = render(<Youniverse />);

        expect(container_item).toEqual(sampleImage);
    })
})